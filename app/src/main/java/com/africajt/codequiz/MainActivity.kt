package com.africajt.codequiz

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ScrollView
import android.widget.Switch
import android.widget.Toast

class MainActivity : Activity() {

    private var score = 0.0
    private var buttonFAB = true
    private val answerText = arrayOf("ANDROID", "PIXEL", "HUAWEI")
    private val answerDouble = doubleArrayOf(4.4, 7.0, 5.0, 8.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab = findViewById<FloatingActionButton>(R.id.all_done_fab)
        fab.setOnClickListener{
            quizFAB()
        }
    }

    /**
     * Checks each Question if it is right and gives a score appropriately
     * It then Toasts the score to the user.
     */
    fun allDone() {
        this.question1()
        this.question2()
        this.question3()
        this.question4()
        this.question5()
        this.question6()
        this.question7()
        this.question8()
        this.question9()
        this.question10()
        this.toastResults()
    }

    /**
     * Displays a long TOAST Message with the user's score rounded off as a percentage
     */
    fun toastResults() {
        val context = applicationContext
        val total = 10.0
        val message = "Your Code Quiz Score is " + Math.round(score / total * 100) + "%"
        val duration = Toast.LENGTH_LONG

        Toast.makeText(context, message, duration).show()
        stopQuiz()
    }

    /**
     * Resets the score and changes the FAB button to allow for a new quiz
     */
    private fun stopQuiz() {
        score = 0.0
        val fab = findViewById<FloatingActionButton>(R.id.all_done_fab)
        fab.setImageResource(R.drawable.ic_autorenew_white_36dp)
    }

    /**
     * Clears all the Questions' Answers, changes the FAB button to allow for a new set of results
     * and Scrolls the view to the top of the Screen
     */
    private fun newQuiz() {
        this.clearQ1()
        this.clearQ2()
        this.clearQ3()
        this.clearQ4()
        this.clearQ5()
        this.clearQ6()
        this.clearQ7()
        this.clearQ8()
        this.clearQ9()
        this.clearQ10()
        val fab = findViewById<FloatingActionButton>(R.id.all_done_fab)
        fab.setImageResource(R.drawable.ic_done_all_white_36dp)

        val sv = findViewById<ScrollView>(R.id.scrollView)
        sv.smoothScrollTo(0, 0)
    }

    /**
     * Checks if the FAB button is to check Results or to Restart Quiz
     * @param view the view the method is called on
     */
    private fun quizFAB(){
        buttonFAB = if (buttonFAB) {
            allDone()
            false
        } else {
            newQuiz()
            true
        }
    }
    /**
     * Checks if the FAB button is to check Results or to Restart Quiz
     * @param view the view the method is called on
     */
    fun quizFAB(view: View) {
        if (buttonFAB) {
            allDone()
            buttonFAB = false
        } else {
            newQuiz()
            buttonFAB = true
        }
    }

    /**
     * Checks if the RadioButton answer of Question 1 from the Code Quiz is correct
     * and increments the score if true
     */
    private fun question1() {
        val answer = findViewById<RadioButton>(R.id.q1_radio_1)
        if (answer.isChecked) {
            score++
        }
    }

    /**
     * Checks if the EditText answer of Question 2 from the Code Quiz is correct
     * and increments the score if true
     */
    private fun question2() {
        val answer = findViewById<EditText>(R.id.q2_answer)
        val answerStr = answer.text.toString().toUpperCase()
        if (answerStr == answerText[0]) {
            score++
        }
    }

    /**
     * Checks if the EditText answer of Question 3 from the Code Quiz is correct
     * and increments the score if true
     */
    private fun question3() {
        val answer = findViewById<EditText>(R.id.q3_answer)
        val answerStr = answer.text.toString().toUpperCase()
        if (answerStr == answerText[1]) {
            score++
        }
    }

    /**
     * Checks if the Switch answer of Question 4 from the Code Quiz is correct
     * and increments the score if true
     */
    private fun question4() {
        val answer = findViewById<Switch>(R.id.q4_switch)

        if (answer.isChecked) {//CHECKED = FALSE TEXT CORRECT
            score++
        }
    }

    /**
     * Checks if the RadioButton answer of Question 5 from the Code Quiz is correct
     * and increments the score if true
     */
    private fun question5() {
        val answer = findViewById<RadioButton>(R.id.q5_radio_3)
        if (answer.isChecked) {
            score++
        }
    }

    /**
     * Checks if the EditText answer of Question 6 from the Code Quiz is correct
     * and increments the score if true
     */
    private fun question6() {
        val answer = findViewById<EditText>(R.id.q6_answer)
        val answerStr = answer.text.toString().toUpperCase()
        if (answerStr == answerText[2]) {
            score++
        }

    }

    /**
     * Checks if the RadioButton answer of Question 5 from the Code Quiz is correct
     * and increments the score if true
     */
    private fun question7() {
        val answer = findViewById<RadioButton>(R.id.q7_radio_3)
        if (answer.isChecked) {
            score++
        }

    }

    /**
     * Checks if multiple EditText answers of Question 8 from the Code Quiz are all correct
     * IF one or more answers are wrong then whole question is deemed incorrect
     * and increments the score if true
     */
    private fun question8() {
        if (doubleCheck(R.id.q8_answer_1) == answerDouble[0]) {
            if (doubleCheck(R.id.q8_answer_2) == answerDouble[1]) {
                if (doubleCheck(R.id.q8_answer_3) == answerDouble[2]) {
                    if (doubleCheck(R.id.q8_answer_4) == answerDouble[3]) {
                        score++
                    }
                }
            }

        }
    }

    /**
     * Checks if the RadioButton answer of Question 9 from the Code Quiz is correct
     * and increments the score if true
     */
    private fun question9() {
        val answer = findViewById<RadioButton>(R.id.q9_radio_3)
        if (answer.isChecked) {
            score++
        } else {
        }
    }

    /**
     * Checks if the Multiple Checkbox answers of Question 10 from the Code Quiz is correct
     * and increments the score if true, if the incorrect answers are also checked then the
     * question is deemed incorrect
     */
    private fun question10() {
        var answer = findViewById<CheckBox>(R.id.q10_checkbox_1)

        if (answer.isChecked) {//CORRECT
            answer = findViewById(R.id.q10_checkbox_2)
            if (!answer.isChecked) {//NOT
                answer = findViewById(R.id.q10_checkbox_3)
                if (answer.isChecked) {//CORRECT
                    answer = findViewById(R.id.q10_checkbox_4)
                    if (!answer.isChecked) {//NOT
                        answer = findViewById(R.id.q10_checkbox_5)
                        if (answer.isChecked) {//CORRECT
                            answer = findViewById(R.id.q10_checkbox_6)
                            if (!answer.isChecked) {//NOT
                                score++
                            }

                        }

                    }
                }

            }
        }
    }


    /**
     * Resets the state of the RadioGroup for Question 1
     */
    private fun clearQ1() {
        val radioGroup = findViewById<RadioGroup>(R.id.q1_radioGroup)
        radioGroup.clearCheck()
    }

    /**
     * Resets the state of the EditText for Question 2
     */
    private fun clearQ2() {
        val editText = findViewById<EditText>(R.id.q2_answer)
        editText.setText("")
    }

    /**
     * Resets the state of the EditText for Question 3
     */
    private fun clearQ3() {
        val editText = findViewById<EditText>(R.id.q3_answer)
        editText.setText("")
    }

    /**
     * Resets the state of the Switch for Question 4
     */
    private fun clearQ4() {
        val aSwitch = findViewById<Switch>(R.id.q4_switch)
        aSwitch.isChecked = false
    }

    /**
     * Resets the state of the RadioGroup for Question 5
     */
    private fun clearQ5() {
        val radioGroup = findViewById<RadioGroup>(R.id.q5_radioGroup)
        radioGroup.clearCheck()
    }

    /**
     * Resets the state of the EditText for Question 6
     */
    private fun clearQ6() {
        val editText = findViewById<EditText>(R.id.q6_answer)
        editText.setText("")
    }

    /**
     * Resets the state of the RadioGroup for Question 7
     */
    private fun clearQ7() {
        val radioGroup = findViewById<RadioGroup>(R.id.q7_radioGroup)
        radioGroup.clearCheck()
    }

    /**
     * Resets the state of all the EditTexts for Question 8
     */
    private fun clearQ8() {
        var editText = findViewById<EditText>(R.id.q8_answer_1)
        editText.setText("")
        editText = findViewById(R.id.q8_answer_2)
        editText.setText("")
        editText = findViewById(R.id.q8_answer_3)
        editText.setText("")
        editText = findViewById(R.id.q8_answer_4)
        editText.setText("")
    }

    /**
     * Resets the state of the RadioGroup for Question 9
     */
    private fun clearQ9() {
        val radioGroup = findViewById<RadioGroup>(R.id.q9_radioGroup)
        radioGroup.clearCheck()
    }

    /**
     * Resets the state of all the CheckBoxes for Question 10
     */
    private fun clearQ10() {
        var checkBox = findViewById<CheckBox>(R.id.q10_checkbox_1)
        checkBox.isChecked = false
        checkBox = findViewById(R.id.q10_checkbox_2)
        checkBox.isChecked = false
        checkBox = findViewById(R.id.q10_checkbox_3)
        checkBox.isChecked = false
        checkBox = findViewById(R.id.q10_checkbox_4)
        checkBox.isChecked = false
        checkBox = findViewById(R.id.q10_checkbox_5)
        checkBox.isChecked = false
        checkBox = findViewById(R.id.q10_checkbox_6)
        checkBox.isChecked = false
    }

    /**
     * Checks to see if the user input is a valid double and not empty
     * @param id the id of the view to check
     * @return the parsed double
     */
    private fun doubleCheck(id: Int): Double {
        val answer = findViewById<EditText>(id)
        val answerStr = answer.text.toString()
        return if (answerStr != "") {
            java.lang.Double.parseDouble(answerStr)
        } else {
            0.0
        }
    }
}
