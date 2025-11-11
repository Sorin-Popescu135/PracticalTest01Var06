package ro.pub.cs.systems.eim.practicaltest01var06

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.view.View

class PracticalTest01var06SecondaryActivity: AppCompatActivity() {
    private var gained: EditText? = null
    private var ok_button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_secondary)

        gained = findViewById<View>(R.id.gained) as EditText
        ok_button = findViewById<View>(R.id.button_ok) as Button

        var nr1 = intent.getIntExtra(Constants.nr1, 0)
        var nr2 = intent.getIntExtra(Constants.nr2, 0)
        var nr3 = intent.getIntExtra(Constants.nr3, 0)
        var nr_checks = intent.getIntExtra(Constants.nr_checks, 0)
        var win = 0
        var last_win = 0
        if(nr1 == nr2 && nr2 == nr3) {
            if (nr_checks == 0){
                win = 100
            } else if (nr_checks == 1) {
                win = 50
            } else if (nr_checks == 2) {
                win = 10
            }

            last_win = win
            gained?.setText(last_win.toString())
        }

        ok_button?.setOnClickListener {
//            val intent = Intent(this, PracticalTest01Var06MainActivity::class.java)
//            intent.putExtra(Constants.win, Integer.valueOf(last_win))
            setResult(last_win)
            finish()
        }
    }
}