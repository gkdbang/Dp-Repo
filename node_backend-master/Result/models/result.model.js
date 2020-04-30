
const mongoose = require('mongoose');


// Question List Schema
const questionAnsweredSchema = new mongoose.Schema({
    questionID:{type:String,required:true},
    questionType:{type: String, required: true},
    questionTitle: {type: String},
    studentAnswered:{type:String},
    correctAnswer:{type:String},
})

// Result Schema
const resultSchema=new mongoose.Schema({
    challengeId:{type:String},
    username: {type: String, required: true, max: 100},
    fathersName: {type: String, required: true,max: 100},
    collegeName: {type: String, required: true,max: 100},
    contactNumber:{type: Number,required:true,max :9999999999},
    emailId:{type: String,required:true },
    birthDate:{type: String,required:true},
    address:{type:String,required:true},
    stream:{type:String,required:true},
    course:{type:String,required:true},
    challengeName:{type: String, required: true},
    durationInMinutesLeft:{type: Number, required: true},
    cutOffMarks:{type: Number},
    resultStatus:{type:String},
    markScored:{type:Number},
    isSubmitted:{type:Boolean},
    questions:[questionAnsweredSchema]
})

// Challenge model
const Result=mongoose.model('Result',resultSchema)


module.exports=Result;


