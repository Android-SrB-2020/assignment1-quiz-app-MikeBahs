package work.nbcc.mikebashkatovassignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*
import work.nbcc.mikebashkatovassignment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var questionIndex = 0;

    private lateinit var questionView: TextView

    private var answer : Boolean = false;

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setContentView(R.layout.activity_main)

        questionView = findViewById(R.id.question_view)

        questionView.setText(questionBank[questionIndex].description)


        backward.setOnClickListener{
                moveBackward();
            }
        forward.setOnClickListener{
                moveForward();
            }
        trueButton.setOnClickListener{
                answer = true;
                checkAnswer();
            }
        falseButton.setOnClickListener{
                answer = false;
                checkAnswer();
            }
    }

    private fun moveForward(){
        questionIndex = (questionIndex + 1) % 20
        questionView.setText(questionBank[questionIndex].description)
    }

    private fun moveBackward(){
        questionIndex = (questionIndex - 1)
        if(questionIndex == 0){
            questionIndex = questionBank.size - 1;
        }
        questionView.setText(questionBank[questionIndex].description)
    }

    private fun checkAnswer(){
        if(questionBank[questionIndex].answer == answer){
            Toast.makeText(getApplicationContext(),
                "You are totally right !",
                Toast.LENGTH_SHORT)
                .show();
        }
        else{
            Toast.makeText(getApplicationContext(),
                "Wrong answer!",
                Toast.LENGTH_SHORT)
                .show();
        }
    }
}
