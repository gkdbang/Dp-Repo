
const Challenge=require('../models/challenge');
const moment=require('moment');

// Saving challenge in db
exports.createChallenge= async(req,res)=>{

    let count=0;
    let alphaNum=Math.random().toString(36).slice(3);
    let challengeName=await Challenge.findOne({challengeName:req.body.challengeName.toLowerCase()})
    if(challengeName==null)
    {
    let questionArr=[];
    for(var i=0;i<req.body.challenges.length;i++){
        let question={};
        question=req.body.challenges[i];
        questionArr.push(question);
    }

    const challenge=new Challenge({
        challengeId:alphaNum,
        challengeName:req.body.challengeName.toLowerCase(),
        durationInMinutes:req.body.durationInMinutes,
        cutOffMarks:req.body.cutOffMarks,
        startDate:req.body.startDate,
        endDate:req.body.endDate,
        challenges:questionArr
    });
    console.log("From postman : "+challenge)
    challenge.save()
        .then(challenge=>{
            res.status(201).send(challenge);
        })
        .catch(err=>{
            res.status(500).json({ message: err.message });
        })
    }
    else{
        res.status(400).send("challenge name already exist");
    }

}

// Get all chacllenge
exports.getAllChallenge=async (req,res)=>{
    console.log("==getAllChallenge==");
    try {
        const challenge= await Challenge.find();
        console.log("All Challenges : ",challenge)
        res.json(challenge);
    } catch (e) {
        res.status(500).json({ message: e.message });
    }
}

// Get one challenge
exports.getOneChallenge=async(req,res)=>{
    console.log("==getOneChallenge==");
    try {
        var challengeName=req.query.challengeName;
        var challengeId=req.params.id
        
        const challenge=await Challenge.findOne({challengeId:req.params.id});
        if (challenge) {
            res.json(challenge);
        } else {
            res.json({message:'Challenge not found with this id'});
        }   
    }
    catch (e) {
        res.status(500).json({ message: e.message });
    }
}




// update challenge in db
exports.updateChallenge=async (req,res)=>{
    try {
       // const challenge=await Challenge.findByIdAndUpdate(req.query.id,req.body);
       const challenge=await Challenge.findOne({challengeId: req.body.challengeId}).updateOne(req.body);
        res.send(challenge);
    } catch (e) {
        res.status(500).json({ message: e.message });
    }
}

// delete challenge by ID
exports.deleteChallenge=async(req,res)=>{
    try {
        const challenge=await Challenge.findByIdAndDelete(req.query.id);
        res.json(challenge);
    } catch (e) {
        res.status(500).json({ message: e.message });
    }
}

// Get challenge by challengeId
exports.getChallengeBychallengeId=async(req,res)=>{
    try {
        const challenge=await Challenge.findOne({challengeId:req.params.challengeId});
        if (challenge) {
            res.json(challenge);
        } else {
            res.json({message:'Challenge not found'});
        }
    } catch (e) {
        res.status(500).json({ message: e.message });
    }
}

exports.getChallengeBychallengeName=async(req,res)=>{
    try{

            const challenge=await Challenge.findOne({challengeName:req.query.challengeName.toLowerCase()});
            if (challenge) {
                res.json(challenge);
            } else {
                res.json({message:'Challenge not found with this name'});
            } 

        }   
    
    catch(e)
    {
        
    }
}



exports.challengeIdEnabled=async(req,res)=>{

    try {
        
        let challenge=await Challenge.findOne({challengeId : req.query.challengeId}).updateOne({"isEnabled": req.body.isEnabled});
        console.log('challenge Updated succesfully')
        res.json(challenge);
     
    } catch (error) {
        res.send("Somthing Went Wrong ! ");
    }
}