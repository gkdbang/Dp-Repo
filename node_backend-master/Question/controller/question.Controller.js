const Question = require('../models/question');
const uploadFileToS3=require('../../util/uploadToS3');
const moment=require('moment');

const path = require("path");

// Saving Question in db
exports.createQuestion = async (req, res) => {

    var now = new Date();
    var dateString = moment(now).format('DD/MM/YYYY HH:mm:ss');
    
    console.log("Files ====: ", req.files);
    let questionTitleImg;
    let image1,image2,image3,image4;
    let path1,path2,path3,path4, titlePath;

        if(req.files){
            let listArr = [];
            if(req.files.questionTitleImg!=null){
                questionTitleImg=req.files.questionTitleImg;
                listArr.push(uploadFileToS3(questionTitleImg,questionTitleImg.name))      
            }
            
            image1=req.files.option1Img;
            image2=req.files.option2Img;
            image3=req.files.option3Img;
            image4=req.files.option4Img;

            listArr.push(uploadFileToS3(image1,image1.name));
            listArr.push(uploadFileToS3(image2,image2.name));
            listArr.push(uploadFileToS3(image3,image3.name));
            listArr.push(uploadFileToS3(image4,image4.name)); 

            //console.log(listArr)

            await Promise.all(listArr).then(resArr=>{
                if(req.files.questionTitleImg!=null){
                    titlePath=resArr[0];
                    path1=resArr[1];
                    path2=resArr[2];
                    path3=resArr[3];
                    path4=resArr[4];
                }
                else{
                    path1=resArr[0];
                    path2=resArr[1];
                    path3=resArr[2];
                    path4=resArr[3];
                }
            }).catch(err => {
                console.log("-->-->-->",err)
            })
            console.log(titlePath,"---",path1,"---",path2,"---",path3,"---",path4);
        }
            
    const question = new Question({
        questionType: req.body.questionType,
        questionTitle: req.body.questionTitle,
        questionTitleImg: titlePath,
        
            option1: req.body.option1,
            option2: req.body.option2,
            option3: req.body.option3,
            option4: req.body.option4,
            
            option1Img: path1,
            option2Img: path2,
            option3Img: path3,
            option4Img: path4,
        
            correctAnswer:req.body.correctAnswer,

            createdDate: dateString,
            createdBy: req.body.createdBy,
            updatedDate: dateString,
            updatedBy: req.body.updatedBy,
        
    });
    //console.log(question);

    question.save()
        .then(question => {
            res.status(201).send(question);
        })
        .catch(err => {
            try {
                res.status(500).json({ message: err.message });
            } catch (er) {

            }
        });            

};

// Getting all the questions from db
exports.getAllQuestions = async (req, res) => {

    console.log('===================>', req.originalUrl)

    var queryStr = req.query.questionType; 

    console.log('id==>', queryStr);
    let question = [];

    try {
        if (queryStr != undefined) {
            question = await Question.find({ questionType: req.query.questionType }).select();
        } else {
            question = await Question.find().select('-_v');
        }

        console.log('length ',question.length);
        res.json(question);
    } catch (e) {
        res.status(500).json({ message: e.message });
    }
};

// Get single question from db based on id
exports.getOneQuestion = async (req, res) => {
    try {

        // var value=req.params.id;

        // console.log(typeof value);

        // let question={};
        // if(typeof value === 'number'){
        //      question=await Question.findById(value).select();
        // }else if(typeof value === 'string'){
        //      question=await Question.findById(value).select();
        // }

        const question = await Question.findById(req.params.id).select();

        console.log("From DB one record : " + question);
        if (question) {
            res.json(question);
        } else {
            return res.status(404).json({ message: 'Question not found!' });
        }

    } catch (e) {
        res.status(500).json({ message: e.message });
    }
}


// Get single question from db based on questionType
exports.getQuestionByQuestionType = async (req, res) => {

    console.log('=========getQuestionByQuestionType==========>', req.originalUrl)

    try {
        console.log("Question Type : " + req.query.questionType);
        const question = await Question.find({ questionType: req.query.questionType }).select();
        console.log("From DB one record : " + question);
        if (question) {
            res.json(question);
        } else {
            return res.status(404).json({ message: 'Question not found!' });
        }

    } catch (e) {
        res.status(500).json({ message: e.message });
    }
}



// Update question in db
exports.updateQuestion = async (req, res) => {
    try {
        console.log("ID : " + req.query.id);
        console.log("Body : " + req.body);
        const question = await Question.findByIdAndUpdate(req.query.id, req.body).select();
        console.log("In update function : " + question)
        res.json(question);
    } catch (e) {
        res.status(500).json({ message: e.message });
    }
}

// Delete question by Id
exports.deleteQuestion = async (req, res) => {
    try {
        const question = await Question.findByIdAndDelete(req.query.id).select();
        res.json(question);
    } catch (e) {
        res.status(500).json({ message: e.message });
    }
}

