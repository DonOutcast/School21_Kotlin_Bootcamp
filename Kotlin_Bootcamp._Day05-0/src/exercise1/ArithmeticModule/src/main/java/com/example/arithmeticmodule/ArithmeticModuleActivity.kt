package com.example.arithmeticmodule.src

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.arithmeticmodule.R
import com.example.loggername.src.Logger
import kotlinx.coroutines.*
import kotlin.math.*


class ArithmeticModuleActivity : AppCompatActivity() {
    var value: Long = 0
    lateinit var textViewFactView: TextView
    lateinit var buttonFactRun: Button
    lateinit var editTextNumberDecimal2: EditText
    var job: Job = Job()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arithmeticmodule)

        val file = this.filesDir.toString()
        editTextNumberDecimal2 = findViewById<EditText>(R.id.editTextNumberDecimal2)
        val buttonAll = findViewById<Button>(R.id.buttonAll)
        textViewFactView = findViewById<TextView>(R.id.textViewFactView)
        buttonFactRun = findViewById<Button>(R.id.buttonFactRun)
        val textViewSquareRootView = findViewById<TextView>(R.id.textViewSquareRootView)
        val textViewCubeRootView = findViewById<TextView>(R.id.textViewCubeRootView)
        val buttonRootRun = findViewById<Button>(R.id.buttonRootRun)
        val textViewLgView = findViewById<TextView>(R.id.textViewLgView)
        val textViewLn = findViewById<TextView>(R.id.textViewLn)
        val buttonRootRun2 = findViewById<Button>(R.id.buttonRootRun2)
        val textViewSquareView = findViewById<TextView>(R.id.textViewSquareView)
        val textViewCube = findViewById<TextView>(R.id.textViewCube)
        val buttonRootRunCube = findViewById<Button>(R.id.buttonRootRunCube)
        val textViewTest = findViewById<TextView>(R.id.textViewTest)
        val buttonTestRun = findViewById<Button>(R.id.buttonTestRun)

        buttonRootRun.setOnClickListener {
            val name = "ArithmeticModuleActivity_SQTR_ROOT"
            if (buttonRootRun.text == "Run") {
                value = getNumer()

                job = GlobalScope.launch(Dispatchers.Default) {
                    Logger.log(file, name, "Start calculate")
                    withContext(Dispatchers.Main) {
                        buttonRootRun.text = "Canceled"
                        val num1As = async { sqrt(value.toDouble()) }
                        val num2As = async { cbrt(value.toDouble()) }

                        val num1 = num1As.await()
                        val num2 = num2As.await()
                        if (isActive) {
                            textViewSquareRootView.text = num1.toString()
                            textViewCubeRootView.text = num2.toString()
                        }
                        Logger.log(file, name, "End calculate")
                        buttonRootRun.text = "Run"
                    }
                }
            } else {
                runBlocking {
                    if (job.isActive) {
                        yield()
                        job.cancel()
                        yield()
                    }
                }
                textViewSquareRootView.text = "Canceled"
                textViewCubeRootView.text = "Canceled"
                buttonRootRun.text = "Run"
                Logger.log(file, name, "Canceled")
            }
            Logger.log(file, name, "Сontinue")
        }

        buttonRootRun2.setOnClickListener {
            val name = "ArithmeticModuleActivity_LG"
            if (buttonRootRun2.text == "Run") {
                value = getNumer()

                job = GlobalScope.launch(Dispatchers.Default) {
                    Logger.log(file, name, "Start calculate")
                    withContext(Dispatchers.Main) {
                        buttonRootRun2.text = "Canceled"
                        val num1As = async { log10(value.toDouble()) }
                        val num2As = async { log2(value.toDouble()) }

                        val num1 = num1As.await()
                        val num2 = num2As.await()
                        if (isActive) {
                            textViewLgView.text = num1.toString()
                            textViewLn.text = num2.toString()
                        }
                        Logger.log(file, name, "End calculate")
                        buttonRootRun2.text = "Run"
                    }
                }
            } else {
                runBlocking {
                    if (job.isActive) {
                        yield()
                        job.cancel()
                        yield()
                    }
                }
                textViewLgView.text = "Canceled"
                textViewLn.text = "Canceled"
                buttonRootRun2.text = "Run"
                Logger.log(file, name, "Canceled")
            }
            Logger.log(file, name, "Сontinue")
        }

        buttonRootRunCube.setOnClickListener {
            val name = "ArithmeticModuleActivity_KVATRAT"
            if (buttonRootRunCube.text == "Run") {
                value = getNumer()

                job = GlobalScope.launch(Dispatchers.Default) {
                    Logger.log(file, name, "Start calculate")
                    withContext(Dispatchers.Main) {
                        buttonRootRunCube.text = "Canceled"
                        val num1As = async { value.toDouble().pow(2.0) }
                        val num2As = async { value.toDouble().pow(3.0) }

                        val num1 = num1As.await()
                        val num2 = num2As.await()
                        if (isActive) {
                            textViewSquareView.text = num1.toString()
                            textViewCube.text = num2.toString()
                        }
                        Logger.log(file, name, "End calculate")
                        buttonRootRunCube.text = "Run"
                    }
                }
            } else {
                if (job.isActive) job.cancel()
                textViewSquareView.text = "Canceled"
                textViewCube.text = "Canceled"
                buttonRootRunCube.text = "Run"
                Logger.log(file, name, "Canceled")
            }
            Logger.log(file, name, "Сontinue")
        }

        buttonTestRun.setOnClickListener {
            val name = "ArithmeticModuleActivity_TEST"
            if (buttonTestRun.text == "Run") {
                value = getNumer()
                job = GlobalScope.launch(Dispatchers.Default) {
                    Logger.log(file, name, "Start calculate")
                    withContext(Dispatchers.Main) {
                        buttonTestRun.text = "Canceled"
                        val sqr = sqrt(value.toDouble()).roundToInt()
                        var ret = true
                        try {
                            withTimeout(500L) {
                                for (i in 2..sqr) {
                                    if (value.mod(i) == 0)
                                        ret = false; break
                                    if (!isActive) break
                                }
                            }
                            if (isActive && ret) textViewTest.text = "Simplicity"
                            if (!ret) textViewTest.text = "Not simplicity"
                        } catch (e: TimeoutCancellationException) {
                            Toast.makeText(
                                applicationContext,
                                "An error has occurred. Please try again.",
                                Toast.LENGTH_SHORT
                            ).show()
                            textViewTest.text = "Error"
                        }
                        Logger.log(file, name, "End calculate")
                        buttonTestRun.text = "Run"
                    }
                }
            } else {
                if (job.isActive) job.cancel()
                textViewTest.text = "Canceled"
                buttonTestRun.text = "Run"
                Logger.log(file, name, "Canceled")
            }
            Logger.log(file, name, "Сontinue")
        }

        buttonFactRun.setOnClickListener {
            val name = "ArithmeticModuleActivity_Factorial"
            if (buttonFactRun.text == "Run") {
                value = getNumer()
                buttonFactRun.text = "Canceled"
                job = GlobalScope.launch(Dispatchers.Default) {
                    Logger.log(file, name, "Start calculate")
                    val num1 = factorial(value, file)
                    withContext(Dispatchers.Main) {
                        if (isActive) {
                            textViewFactView.text = num1
                        }
                        buttonFactRun.text = "Run"
                        Logger.log(file, name, "End calculate")
                    }
                }
            } else {
                if (job.isActive) {
                    job.cancel()
                }
                textViewFactView.text = "Canceled"
                buttonFactRun.text = "Run"
                Logger.log(file, name, "Canceled")
            }
            Logger.log(file, name, "Сontinue")
        }

        buttonAll.setOnClickListener {
            val name = "ArithmeticModuleActivity_RUN_ALL"
            Logger.log(file, name, "Start calculate")
            buttonRootRun.performClick()
            buttonRootRun2.performClick()
            buttonRootRunCube.performClick()
            buttonTestRun.performClick()
            buttonFactRun.performClick()
            Logger.log(file, name, "End calculate")
        }

        editTextNumberDecimal2.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) hideKeyboard(View(this))
        }

        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun getNumer(): Long {
        val num = editTextNumberDecimal2.text.toString().toLongOrNull()
        if (num != null) return num
        else {
            Toast.makeText(
                applicationContext,
                "An error has occurred. Please try again.",
                Toast.LENGTH_SHORT
            ).show()
            return 0
        }

    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}