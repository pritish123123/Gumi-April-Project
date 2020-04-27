package com.example.gumivietnam

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.text.Editable
import android.util.Patterns
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textView = findViewById<TextView>(R.id.forgot)


        textView.setOnClickListener {

            Toast.makeText(
                this@LoginActivity,
                "You just clicked on forget password",
                Toast.LENGTH_SHORT
            ).show()
        }

        val textView2 = findViewById<TextView>(R.id.account)

        textView2.setOnClickListener {
            Toast.makeText(this@LoginActivity,
                "You want ro create a account",
                Toast.LENGTH_SHORT)
                .show()

        }

        login.setOnClickListener {

            val input = email.editText?.text
            val input2 = password.editText?.text

            if (input != null)
            {
                if (input.isEmpty())
                {
                    Toast.makeText(this@LoginActivity,
                        "Email can't be empty",
                        Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener

                } else if (!Patterns.EMAIL_ADDRESS.matcher(input).matches())
                {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please enter a valid email address",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
            }

            if (input2 != null)
            {
                if (input2.isEmpty())
                {
                    Toast.makeText(this@LoginActivity, "Password can't be empty", Toast.LENGTH_LONG)
                        .show()
                    return@setOnClickListener
                } else if (input2.length < 8)
                {
                    Toast.makeText(
                        this@LoginActivity,
                        "Password lenght must be 8 Character's",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }
                var exp = ".*[0-9].*"
                var pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE)
                var matcher = pattern.matcher(input2)
                 if (!matcher.matches())
                {
                    Toast.makeText(
                        this@LoginActivity,
                        "Password Contain at-least 1 number",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }
                exp = ".*[A-Z].*"
                pattern = Pattern.compile(exp)
                matcher = pattern.matcher(input2)
                if (!matcher.matches())
                {
                    Toast.makeText(
                        this@LoginActivity,
                        "Password Contain at-least 1 Upper Case character",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }

                // Password should contain at least one small letter
                exp = ".*[a-z].*"
                pattern = Pattern.compile(exp)
                matcher = pattern.matcher(input2)
                if (!matcher.matches())
                {
                    Toast.makeText(
                        this@LoginActivity,
                        "Password Contain at-least 1 Small character",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }

                // Password should contain at least one special character
                // Allowed special characters : "~!@#$%^&*()-_=+|/,."';:{}[]<>?"
                exp = ".*[~!@#\$%\\^&*()\\-_=+\\|\\[{\\]};:'\",<.>/?].*"
                pattern = Pattern.compile(exp)
                matcher = pattern.matcher(input2)
                if (!matcher.matches())
                {
                    Toast.makeText(
                        this@LoginActivity,
                        "Password Contain at-least 1 special character",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }
                else
                {
                    val intent = Intent(this@LoginActivity, ShowListActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
