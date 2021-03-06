package com.example.testdrive

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val cIncorrect = { number: Int -> 20 - number}
        var strScore=intent.getStringExtra("score")
        var name=intent.getStringExtra("name")

        val strName ="Hey " to name

        var score=strScore.toInt()
        var tcorrect=score
        var tincorrect=cIncorrect(tcorrect)
        var perScore:Double=(score.toDouble()/20)*100
        var qualify=""
        var strPer=perScore.toString()
        var strPoints=""

        if (strPer.length>=5){
            strPoints=strPer.substring(0,5)
        }else{
            strPoints=strPer
        }

        if (score>=10){
            qualify="PASSED"
            btn_result.setBackgroundResource(R.drawable.btn_bg_green)
        }else{
            qualify="FAILED"
            btn_result.setBackgroundResource(R.drawable.btn_bg_red)
        }

        txt_name.text="${strName.first + strName.second}"
        txt_points.text="$strPoints %"
        txt_total_correct.text="Total correct answers   ${tcorrect.toString()}"
        txt_total_incorrect.text="Total incorrect answers   ${tincorrect.toString()}"
        btn_result.text="$qualify"

        //Toast.makeText(this,"Score on Score : $score", Toast.LENGTH_LONG).show()

    }

}