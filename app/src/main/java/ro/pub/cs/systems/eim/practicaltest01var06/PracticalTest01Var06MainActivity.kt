package ro.pub.cs.systems.eim.practicaltest01var06

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast

class PracticalTest01Var06MainActivity : AppCompatActivity() {

    private var play_button: Button? = null

    private var nr_1: EditText? = null
    private var nr_2: EditText? = null
    private var nr_3: EditText? = null

    private var check_1: CheckBox? = null
    private var check_2: CheckBox? = null
    private var check_3: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_main)

        play_button = findViewById<View>(R.id.play_button) as Button
        check_1 = findViewById<CheckBox>(R.id.checkbox_1) as CheckBox
        check_2 = findViewById<CheckBox>(R.id.checkbox_2) as CheckBox
        check_3 = findViewById<CheckBox>(R.id.checkbox_3) as CheckBox

        nr_1 = findViewById<View>(R.id.nr_1) as EditText
        nr_2 = findViewById<View>(R.id.nr_2) as EditText
        nr_3 = findViewById<View>(R.id.nr_3) as EditText

        play_button?.setOnClickListener {
            if (check_1?.isChecked() == false) {
                val rnds = intArrayOf(1, 2, 3).random()
                nr_1?.setText(rnds.toString())

            }

            if (check_2?.isChecked() == false) {
                val rnds = intArrayOf(1, 2, 3).random()
                nr_2?.setText(rnds.toString())

            }

            if (check_3?.isChecked() == false) {
                val rnds = intArrayOf(1, 2, 3).random()
                nr_3?.setText(rnds.toString())

            }

            Toast.makeText(this, "The numbers:" + nr_1?.text.toString() + nr_2?.text.toString() + nr_3?.text.toString(), Toast.LENGTH_SHORT).show()

        }

    }
}