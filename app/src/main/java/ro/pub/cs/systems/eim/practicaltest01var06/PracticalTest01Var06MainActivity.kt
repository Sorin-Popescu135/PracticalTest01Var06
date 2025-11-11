package ro.pub.cs.systems.eim.practicaltest01var06

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class PracticalTest01Var06MainActivity : AppCompatActivity() {

    private var play_button: Button? = null
    private var navigate: Button? = null

    private var nr_1: EditText? = null
    private var nr_2: EditText? = null
    private var nr_3: EditText? = null

    private var check_1: CheckBox? = null
    private var check_2: CheckBox? = null
    private var check_3: CheckBox? = null

    private var total_gain: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_main)

        play_button = findViewById<View>(R.id.play_button) as Button
        navigate = findViewById<View>(R.id.navigate_to_secondary) as Button

        check_1 = findViewById<CheckBox>(R.id.checkbox_1) as CheckBox
        check_2 = findViewById<CheckBox>(R.id.checkbox_2) as CheckBox
        check_3 = findViewById<CheckBox>(R.id.checkbox_3) as CheckBox

        nr_1 = findViewById<View>(R.id.nr_1) as EditText
        nr_2 = findViewById<View>(R.id.nr_2) as EditText
        nr_3 = findViewById<View>(R.id.nr_3) as EditText
        var nr_checks = 0
        var nr1 = 0
        var nr2 = 0
        var nr3 = 0

        play_button?.setOnClickListener {
            nr_checks = 0
            var nr1 = 0
            var nr2 = 0
            var nr3 = 0

            if (check_1?.isChecked() == false) {
                val rnds = intArrayOf(1, 2, 3).random()
                nr_1?.setText(rnds.toString())
                nr1 = rnds
            } else {
                nr_checks++
            }

            if (check_2?.isChecked() == false) {
                val rnds = intArrayOf(1, 2, 3).random()
                nr_2?.setText(rnds.toString())
                nr2 = rnds
            } else {
                nr_checks++
            }

            if (check_3?.isChecked() == false) {
                val rnds = intArrayOf(1, 2, 3).random()
                nr_3?.setText(rnds.toString())
                nr3 = rnds
            } else {
                nr_checks++
            }
            Toast.makeText(this, "The numbers:" + nr_1?.text.toString() + nr_2?.text.toString() + nr_3?.text.toString(), Toast.LENGTH_SHORT).show()

        }

        navigate?.setOnClickListener {
            val intent = Intent(this, PracticalTest01var06SecondaryActivity::class.java)
            intent.putExtra(Constants.nr1, Integer.valueOf(nr1))
            intent.putExtra(Constants.nr2, Integer.valueOf(nr2))
            intent.putExtra(Constants.nr3, Integer.valueOf(nr3))
            intent.putExtra(Constants.nr_checks, Integer.valueOf(nr_checks))
            activityResultsLauncher.launch(intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(Constants.total_gain, total_gain.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState.containsKey(Constants.total_gain)) {
             total_gain = savedInstanceState.getString(Constants.total_gain)?.toInt() ?: 0
        }
    }

    val activityResultsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            var last_win = intent.getIntExtra(Constants.win, 0)
            total_gain += result.resultCode
            Toast.makeText(this, "Total Win: " + total_gain.toString(), Toast.LENGTH_LONG).show()


    }
}