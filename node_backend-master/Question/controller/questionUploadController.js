const QuestionUpload = require('../models/excelQuestion');
const moment=require('moment');

const XLSX=require('xlsx');
const path = require("path")

exports.uploadQuestion = async (req, res) => {

    try {
        if (!req.files) {
            res.json({"message":"No file uploaded"});
        } else {
            let fileUpload=req.files.fileUploader;
        
            let getTimeStamp = new Date().getTime();
            await fileUpload.mv(path.join(__dirname + "../../../Exceluploads/") +getTimeStamp + "_" + fileUpload.name);
            
            var workbook=await XLSX.readFile(path.join(__dirname + "../../../Exceluploads/") + getTimeStamp + "_" + fileUpload.name);
            
            var sheet_name_list = workbook.SheetNames;
            var xlData = XLSX.utils.sheet_to_json(workbook.Sheets[sheet_name_list[0]]);
            //console.log(xlData);
            //saveQuestion(xlData);
            //res.json(xlData);
            const questionUpload=new QuestionUpload({
                excelData:xlData
             });
    
             questionUpload.save()
             .then(questionUpload => {
                res.status(201).send(questionUpload);
            })
            .catch(err => {
                try {
                    console.log("ERROR==========")
                    res.status(500).json({ message: err.message });
                } catch (er) {
    
                }
            });
        }
        
    } catch (err) {
        res.status(500).send(err);
    }  

}

// function saveQuestion(xlData){
//         //  var now = new Date();
//         //  var dateString = moment(now).format('DD/MM/YYYY HH:mm:ss');
//         //  console.log("Current Date : "+dateString);
         
//          const questionUpload=new QuestionUpload({
//             excelData:xlData
//          });

//          questionUpload.save()
//          .then(questionUpload => {
//             res.status(201).send(questionUpload);
//         })
//         .catch(err => {
//             try {
//                 res.status(500).json({ message: err.message });
//             } catch (er) {

//             }
//         });

// }
