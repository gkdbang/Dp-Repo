const Result=require('../models/result.model');
const User=require('../../User/models/user.model');
const mongoose = require('mongoose');



var ResultJsonForUI ={
    username: {type: String, required: true, max: 100},
    lastname:{type:String,required:true},
    emailId:{type: String,required:true },
    collegeName: {type: String, required: true,max: 100},
    challengeName:{type: String, required: true},
    cutOffMarks:{type: Number},
    markScored:{type:Number},
    resultStatus:{type:String},
    
}


exports.generateResult=async (req,res)=>{

    let markScored=0;
    let questionArr=[];
    let resultStatus="fail";

    let resultId=await Result.findOne({emailId:req.body.emailId});
    
    if(resultId==null)
    {
    for(var i=0;i<req.body.questions.length;i++){
        let question={};
        question=req.body.questions[i];
        if(question.studentAnswered==question.correctAnswer)
        {
           markScored=markScored+1;
        }
        else{
            markScored=markScored;
        }

        questionArr.push(question);
    }
    if(markScored>=req.body.cutOffMarks)
    {
console.log("marks scored:= "+markScored);
resultStatus="pass"
    }

    const result=new Result({
        challengeId:req.body.challengeId,
        username:req.body.username,
        fathersName:req.body.fathersName,
        collegeName:req.body.collegeName,
        contactNumber:req.body.contactNumber,
        emailId: req.body.emailId,
        birthDate:req.body.birthDate,  
        address: req.body.address,
        stream: req.body.stream,
        course:req.body.course,
        challengeName:req.body.challengeName,
        durationInMinutesLeft:req.body.durationInMinutesLeft,
        cutOffMarks:req.body.cutOffMarks,
        resultStatus:resultStatus,
        markScored:markScored,
        isSubmitted:req.body.isSubmitted,
        questions:questionArr
    });
   // console.log("From postman : "+result)
    result.save()
        .then(async result=>{
            if(req.body.isSubmitted==true)
            {
            let userData=await User.findOne({emailId:result.emailId});
            userData.isEnable=false;
            let userStatus=await User.findByIdAndUpdate(userData.id,userData).select();
        }
            res.status(201).send(result);
        })
        .catch(err=>{
            res.status(500).json({ message: err.message });
        })
    }
    else{
        try{
         //   var res=await Result.findOne({emailId:req.body.emailId});

         console.log(req.body);
         for(var i=0;i<req.body.questions.length;i++){
            let question={};
            question=req.body.questions[i];
            if(question.studentAnswered==question.correctAnswer)
            {
               markScored=markScored+1;
            }
            else{
                markScored=markScored;
            }
    
            questionArr.push(question);
        }
        if(markScored>=req.body.cutOffMarks)
        {
    console.log("marks scored:= "+markScored);
    resultStatus="pass"
        }
    

        var result1=await (await Result.findOne({emailId:req.body.emailId})).updateOne({ challengeId:req.body.challengeId,
            username:req.body.username,
            fathersName:req.body.fathersName,
            collegeName:req.body.collegeName,
            contactNumber:req.body.contactNumber,
            emailId: req.body.emailId,
            birthDate:req.body.birthDate,  
            address: req.body.address,
            stream: req.body.stream,
            course:req.body.course,
            challengeName:req.body.challengeName,
            durationInMinutesLeft:req.body.durationInMinutesLeft,
            cutOffMarks:req.body.cutOffMarks,
            resultStatus:resultStatus,
            markScored:markScored,
            isSubmitted:req.body.isSubmitted,
            questions:questionArr})

      //  var result1=await Result.findOneAndUpdate({emailId:req.body.emailId},r);
        if(req.body.isSubmitted==true)
        {
          let user=await User.findOne({emailId:req.body.emailId}).updateOne({"isEnable":"false"});
           res.status(201);
    }
    
     res.status(201).send("result updated");
    }
    catch(err)
    {
        res.status(500).json({ message: err.message });   

    }
}
}


//Api for generating Report
exports.getReportForTheChallenge=async(req,res)=>{
    
    try {
        const report=await Result.find({challengeId:req.query.challengeId});
        var reportForUI=[];
        console.log("req :"+req.query.challengeId);

        console.log("report Length= "+report.length ,report[0].resultStatus);
        if (report.length>0) {
            for(var i=0;i<report.length;i++)
            {

ResultJsonForUI={
    username: report[i].username,
    lastname:report[i].fathersName,
    emailId:report[i].emailId,
    collegeName:report[i].collegeName,
    challengeName:report[i].challengeName,
    cutOffMarks:report[i].cutOffMarks,
    markScored:report[i].markScored,
    resultStatus:report[i].resultStatus,

}
reportForUI.push(ResultJsonForUI);
            }
            res.json(reportForUI);
            
        } else {
            res.json({message:'This challenge id does not exist'});
        }      
    } catch (e) {
        res.status(500).json({ message: e.message });
    }
}



