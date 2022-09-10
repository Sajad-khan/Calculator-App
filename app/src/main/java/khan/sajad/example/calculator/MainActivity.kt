package khan.sajad.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import khan.sajad.example.calculator.databinding.ActivityMainBinding
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var inputString = ""
    private var lastDecimal = false
    private var lastPoint = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.one.setOnClickListener{
            inputString+="1"
            binding.resultTextview.text = inputString
            lastDecimal = true
            lastPoint = false
        }
        binding.two.setOnClickListener{
            inputString+="2"
            binding.resultTextview.text = inputString
            lastDecimal = true
            lastPoint = false
        }
        binding.three.setOnClickListener{
            inputString+="3"
            binding.resultTextview.text = inputString
            lastDecimal = true
            lastPoint = false
        }
        binding.four.setOnClickListener{
            inputString+="4"
            binding.resultTextview.text = inputString
            lastDecimal = true
            lastPoint = false
        }
        binding.five.setOnClickListener{
            inputString+="5"
            binding.resultTextview.text = inputString
            lastDecimal = true
            lastPoint = false
        }
        binding.six.setOnClickListener{
            inputString+="6"
            binding.resultTextview.text = inputString
            lastDecimal = true
            lastPoint = false
        }
        binding.seven.setOnClickListener{
            inputString+="7"
            binding.resultTextview.text = inputString
            lastDecimal = true
            lastPoint = false
        }
        binding.eight.setOnClickListener{
            inputString+="8"
            binding.resultTextview.text = inputString
            lastDecimal = true
            lastPoint = false
        }
        binding.nine.setOnClickListener{
            inputString+="9"
            binding.resultTextview.text = inputString
            lastDecimal = true
            lastPoint = false
        }
        binding.zero.setOnClickListener{
            inputString+="0"
            binding.resultTextview.text = inputString
            lastDecimal = true
            lastPoint = false
        }

        binding.multiply.setOnClickListener{
            if(lastDecimal && !hasOperator()){
                inputString+="*"
                binding.resultTextview.text = inputString
                lastDecimal = false
            }
        }
        binding.divide.setOnClickListener{
           if(lastDecimal && !hasOperator()){
               inputString+="/"
               binding.resultTextview.text = inputString
               lastDecimal = false
           }
        }
        binding.plus.setOnClickListener{
            if(lastDecimal && !hasOperator()){
                inputString+="+"
                binding.resultTextview.text = inputString
                lastDecimal = false
            }
        }
        binding.minus.setOnClickListener{
            if(lastDecimal && !hasOperator()){
                inputString+="-"
                binding.resultTextview.text = inputString
                lastDecimal = false
            }
        }
        binding.dot.setOnClickListener{
            if(lastDecimal && !lastPoint){
                inputString+="."
                binding.resultTextview.text = inputString
                lastDecimal = false
                lastPoint = true
            }
        }
        binding.equals.setOnClickListener{
            if(lastDecimal){
                onEquals()
                lastDecimal = true
            }
        }
        binding.clear.setOnClickListener{
            inputString = ""
            binding.resultTextview.text = inputString
        }
    }

    private fun hasOperator(): Boolean{
        if(inputString.contains('/')
            ||inputString.contains('+')
            ||inputString.contains('-')
            ||inputString.contains('*')) return true

        return false
    }
    private fun onEquals(){
        if(lastDecimal && hasOperator()){
            if(inputString.contains('-')){
                val splitString = inputString.split("-")
                val firstNum = splitString[0].toDouble()
                val secNum = splitString[1].toDouble()

                val ans = firstNum - secNum
                binding.resultTextview.text = ans.toString()
                inputString = ans.toString()
            }
            else  if(inputString.contains('+')){
                val splitString = inputString.split("+")
                val firstNum = splitString[0].toDouble()
                val secNum = splitString[1].toDouble()

                val ans = firstNum + secNum
                binding.resultTextview.text = ans.toString()
                inputString = ans.toString()
            }
            else  if(inputString.contains('*')){
                val splitString = inputString.split("*")
                val firstNum = splitString[0].toDouble()
                val secNum = splitString[1].toDouble()

                val ans = firstNum * secNum
                binding.resultTextview.text = ans.toString()
                inputString = ans.toString()
            }
            else {
                val splitString = inputString.split("/")
                val firstNum = splitString[0].toDouble()
                val secNum = splitString[1].toDouble()

                try{
                    val ans = firstNum / secNum
                    binding.resultTextview.text = ans.toString()
                    inputString = ans.toString()
                }
                catch (e: ArithmeticException){

                }
            }
        }
    }
}