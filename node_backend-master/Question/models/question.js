const mongoose = require('mongoose');


// Question Schema
const questionSchema = new mongoose.Schema({
    questionType:{type: String, required: true},
    questionTitle: {type: String},
    questionTitleImg: {type: String},
    option1: {type: String},
    option2: {type: String},
    option3: {type: String},
    option4: {type: String},

    option1Img: {type: String},
    option2Img: {type: String},
    option3Img: {type: String},
    option4Img: {type: String},

    correctAnswer:{type:String},


    isEnabled:{type: Boolean,default:"true"},
    createdDate:{type: String},
    createdBy:{type: String},
    updatedDate:{type: String},
    updatedBy:{type: String}
})
 
// Question Model
const Question = mongoose.model('Question', questionSchema);

module.exports=Question;