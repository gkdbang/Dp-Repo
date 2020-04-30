const mongoose = require('mongoose');


// QuestionUpload Schema
const questionUploadSchema = new mongoose.Schema({
    excelData:[],
})

// Question Model
const QuestionUpload = mongoose.model('excelQuestion', questionUploadSchema);

module.exports=QuestionUpload;