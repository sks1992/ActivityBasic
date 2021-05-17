package com.skkotlin.activity_basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

/*An activity is a single, focused thing that the user can do. the activity serves as
the entry point for an app's interaction with the user, so the Activity class takes
care of creating a window for you in which you can place your UI with setContentView(View)*/

class MainActivity : AppCompatActivity() {
    /*There are two methods almost all subclasses of Activity will implement:
1.onCreate(Bundle) is where you initialize your activity. Most importantly, here you will
 usually call setContentView(int) with a layout resource defining your UI, and using
 findViewById(int) to retrieve the widgets in that UI that you need to interact with
  programmatically.
2.onPause() is where you deal with the user pausing active interaction with the activity.
 Any changes made by the user should at this point be committed (usually to the
 ContentProvider holding the data). In this state the activity is still visible on
 screen.*/

    val TAG="ActivityA"

    /*onCreate ==> Called when the activity is first created. This is where you should
    do all of your normal static set up: create views, bind data to lists, etc. This
    method also provides you with a Bundle containing the activity's previously frozen
    state, if there was one.Always followed by onStart().*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate")

        var textView =findViewById<TextView>(R.id.tvHello)
        val sendData = findViewById<Button>(R.id.btnSend)
        var message =textView.text.toString()

        sendData.setOnClickListener {

            //Explicit intent example
           val intent =Intent(this,SecondActivity::class.java)
            intent.putExtra("Message",message)
            startActivity(intent)

            //Implicit intent example
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND //Action type
                type = "text/plain" //which type data want to send
                putExtra(Intent.EXTRA_TEXT, message) //data you want to send
            }
            startActivity(sendIntent)

        }

    }


/*onStart ==> Called when the activity is becoming visible to the user.
Followed by onResume() if the activity comes to the foreground, or onStop() if it
 becomes hidden.*/
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }
/*onResume ==> The system invokes this callback just before the activity starts interacting with
the user. At this point, the activity is at the top of the activity stack, and captures all user
input. Most of an app’s core functionality is implemented in the onResume() method.

The onPause() callback always follows onResume().*/
    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }
/*onPause ==>The system calls onPause() when the activity loses focus and enters a Paused state.
This state occurs when, for example, the user taps the Back or Recents button. When the system
calls onPause() for your activity, it technically means your activity is still partially visible,
but most often is an indication that the user is leaving the activity, and the activity will soon
enter the Stopped or Resumed state.

An activity in the Paused state may continue to update the UI if the user is expecting the UI to
update. Examples of such an activity include one showing a navigation map screen or a media
player playing. Even if such activities lose focus, the user expects their UI to continue
updating.
*/
    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }
/*onStop==>The system calls onStop() when the activity is no longer visible to the user. This
may happen because the activity is being destroyed, a new activity is starting, or an existing
activity is entering a Resumed state and is covering the stopped activity. In all of these
cases, the stopped activity is no longer visible at all.

The next callback that the system calls is either onRestart(), if the activity is coming back
to interact with the user, or by onDestroy() if this activity is completely terminating*/
    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }
/*onDestroy ==> The system invokes this callback before an activity is destroyed.

This callback is the final one that the activity receives. onDestroy() is usually implemented
to ensure that all of an activity’s resources are released when the activity, or the process
containing it, is destroyed.*/
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }
/*onRestart ==>The system invokes this callback when an activity in the Stopped state is
bout to restart. onRestart() restores the state of the activity from the time that it was stopped.

This callback is always followed by onStart().
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart")
    }*/
}

/*Q1.==>Lifecycle methods when an activity start?
* Ans=> 1.onCreate()  2.onStart()  3.onResume*/

/*Q2.==>Lifecycle methods when an activity go to Background by pressing HomeButton?
* Ans=> 1.onPause()  2. onStop()*/

/*Q2.1.==>Lifecycle methods when an activity go to foreground after pressing HomeButton?
* Ans=>  1.onStart()  2.onResume*/

/*Q3.==>Lifecycle methods when an activity go to Background by pressing BackButton?
* Ans=> 1.onPause()  2. onStop()  3.onDestroy()*/

/*Q4.==>Lifecycle methods when an activity go to foreground after pressing BackButton?
* Ans=> 1.onCreate()  2.onStart()  3.onResume*/

/*Q5.==>Lifecycle methods when an activity go to Background by pressing OverViewButton?
* Ans=> 1.onPause()  2. onStop()*/

/*Q6.==>Lifecycle methods when an activity go to foreground after pressing OverViewButton?
* Ans=>  1.onStart()  2.onResume*/

/*Q7.==>Lifecycle methods when an activity Destroy?
* Ans=> 1.onDestroy()*/

/*Q8.==>Lifecycle methods when an activity show dialog and a dialog on Fullscreen?
* Ans=> when dialog show no change and when a dialog on full screen also no change*/