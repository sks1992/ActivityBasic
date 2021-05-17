package com.skkotlin.activity_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    val TAG ="ActivityB"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(TAG,"onCreate")
        val message =intent.getStringExtra("Message")
        val textMessage =findViewById<TextView>(R.id.textView)
        textMessage.text = message
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }
}

/*Q.1 ==>Activity lifecycle CallBack on Activity A go to Activity B?
* Ans=> Activity A           Activity B
*       1.onPause()
*                           2.onCreate()
*                           3.onStart()
*                           4.onResume()
*       5.onStop()
* */

/*Q.2 ==>Activity lifecycle Called on when we on Activity B and press backButton Go to Activity A?
* Ans=> Activity A           Activity B
*                           1.onPause()
*       2.onStart()
*       3.onResume()
*                           4.onStop()
*                           5.onDestroy()
* */
/*Q.3 ==>Activity lifecycle Called on when we on Activity B and press homeButton?
* Ans=> Activity A           Activity B
*                           1.onPause()
*                           2.onStop()
* */
/*Q.4 ==>Activity lifecycle Called on when we on Activity B and press OverViewButton?
* Ans=> Activity A           Activity B
*                           1.onPause()
*                           2.onStop()
* */
/*Q.5 ==>Activity lifecycle Called on when we on Activity B and ActivityDestroyed?
* Ans=> Activity A           Activity B
*       1.onDestroy()
* */