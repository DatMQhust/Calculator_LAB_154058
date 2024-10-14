package com.example.calculator_v0

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var textResult: TextView
    lateinit var textPreview: TextView
    var state: Int = 1;
    private var op: Int = 0
    private var op1: Int = 0
    private var op2: Int = 0
    var optemp : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.textResult)
        textPreview = findViewById(R.id.textPreview)
        findViewById<Button>(R.id.bs_btn).setOnClickListener(this)
        findViewById<Button>(R.id.ce_btn).setOnClickListener(this)
        findViewById<Button>(R.id.c_btn).setOnClickListener(this)
        findViewById<Button>(R.id.divide).setOnClickListener(this)
        findViewById<Button>(R.id.minus).setOnClickListener(this)
        findViewById<Button>(R.id.plus).setOnClickListener(this)
        findViewById<Button>(R.id.btn_changemode).setOnClickListener(this)
        findViewById<Button>(R.id.multi).setOnClickListener(this)
        findViewById<Button>(R.id.btn_cham).setOnClickListener(this)
        findViewById<Button>(R.id.equal).setOnClickListener(this)
        findViewById<Button>(R.id.btn_0).setOnClickListener(this)
        findViewById<Button>(R.id.btn_1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_2).setOnClickListener(this)
        findViewById<Button>(R.id.btn_3).setOnClickListener(this)
        findViewById<Button>(R.id.btn_4).setOnClickListener(this)
        findViewById<Button>(R.id.btn_5).setOnClickListener(this)
        findViewById<Button>(R.id.btn_6).setOnClickListener(this)
        findViewById<Button>(R.id.btn_7).setOnClickListener(this)
        findViewById<Button>(R.id.btn_8).setOnClickListener(this)
        findViewById<Button>(R.id.btn_9).setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        // Nhập các số
        if (id == R.id.btn_0) {
            addDigitInterger(0 )
        } else if (id == R.id.btn_1) {
            addDigitInterger(1 )
        } else if (id == R.id.btn_2) {
            addDigitInterger(2 )
        } else if (id == R.id.btn_3) {
            addDigitInterger(3 )
        } else if (id == R.id.btn_4) {
            addDigitInterger(4 )
        } else if (id == R.id.btn_5) {
            addDigitInterger(5 )
        } else if (id == R.id.btn_6) {
            addDigitInterger(6 )
        } else if (id == R.id.btn_7) {
            addDigitInterger(7 )
        } else if (id == R.id.btn_8) {
            addDigitInterger(8 )
        } else if (id == R.id.btn_9) {
            addDigitInterger(9 )
        }
        // Xử lý các phép tinh + - * /
        else if (id == R.id.plus) {
            op = 1
            if (optemp != 0)
            textPreview.text = "$optemp +"
            else textPreview.text = "$op1 +"
            if (state == 1) state = 2

        } else if (id == R.id.minus) {
            op = 2
            if (optemp != 0)
                textPreview.text = "$optemp -"
            else textPreview.text = "$op1 -"
            if (state == 1) state = 2

        } else if (id == R.id.multi) {
            op = 3
            if (optemp != 0)
                textPreview.text = "$optemp x"
            else textPreview.text = "$op1 x"
            if (state == 1) state = 2

        } else if (id == R.id.divide) {
            op = 4
            if (optemp != 0)
                textPreview.text = "$optemp /"
            else textPreview.text = "$op1 /"
            if (state == 1) state = 2

        }
        // Xử lý các nút đăc biệt
        else if (id == R.id.c_btn) {
            state = 1
            op1 = 0
            op2 = 0
            textResult.text = "0"
            textPreview.text = ""

        } else if (id == R.id.ce_btn) {
            if (state == 1) {
                op1 = 0
                textResult.text = "$op1"
                textPreview.text = ""
            } else {
                op2 = 0
                textResult.text = "$op2"
            }

        } else if (id == R.id.btn_changemode) {
            if (state == 1) {
                    if (optemp == 0) {
                        op1 = 0 - op1
                        textResult.text = "$op1"
                    }
                    else {
                        optemp = 0-optemp
                        textResult.text="$optemp"
                    }
            } else {
                op2 = 0 - op2
                textResult.text = "$op2"
            }
        } else if (id == R.id.bs_btn) {
            if (state == 1) {
                op1 = op1 / 10
                textResult.text = "$op1"
            } else {
                op2 = op2 / 10
                textResult.text = "$op2"
            }
        }
        // Xử lý nút =
        else if (id == R.id.equal) {

            // Xử lý trường hợp số nguyên
            var result = 0
                if (op == 1) {
                    if (optemp != 0) op1 = optemp
                    result = op1 + op2
                    textPreview.text = "$op1 + $op2 ="

                } else if (op == 2) {
                    if (optemp != 0) op1 = optemp
                    result = op1 - op2
                    textPreview.text = "$op1 - $op2 ="

                } else if (op == 3) {
                    if (optemp != 0) op1 = optemp
                    result = op1 * op2
                    textPreview.text = "$op1 x $op2 ="

                }
                else if (op == 4){
                    if (op2 == 0){
                        textPreview.text = "$op1 /"
                    }
                    else if (optemp == 0) textPreview.text = "$op1 / $op2 ="
                    else textPreview.text="$optemp / $op2 ="
                }
                if (op2 == 0 && op == 4) {
                    textResult.text = "Cannot divide by zero"
                    state = 2
                    op = 4
                } else {
                    if (op != 4) {
                        textResult.text = "$result"
                        state = 1
                        optemp = result
                        op1=0
                        op2 = 0

                    } else {
                        if (optemp != 0) op1 = optemp
                        var s = op1.toDouble() / op2.toDouble()
                        textResult.text = "$s"
                        optemp = s.toInt()
                        state = 1
                        op1= 0
                        op2=0

                    }


                }




        }

    }

    // Hàm thêm số mới
    fun addDigitInterger(c: Int) {

        if (state == 1) {
            if (optemp != 0) optemp = 0
                op1 = (op1.toString() + c.toString()).toInt()
                textResult.text = "$op1"
            }

        if (state == 2) {
                op2 = (op2.toString() + c.toString()).toInt()
                textResult.text = "$op2"

        }

    }


}
