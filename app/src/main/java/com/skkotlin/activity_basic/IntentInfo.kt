package com.skkotlin.activity_basic

/*Intent:==>An Intent is a messaging object you can use to request an action from another app
 component. Although intents facilitate communication between components in several ways,
 there are three fundamental use cases:

 1.Starting an activity
An Activity represents a single screen in an app. You can start a new instance of an Activity
by passing an Intent to startActivity(). The Intent describes the activity to start and carries
any necessary data.

If you want to receive a result from the activity when it finishes, call
startActivityForResult(). Your activity receives the result as a separate Intent object in your
 activity's onActivityResult() callback

 2.Starting a service
A Service is a component that performs operations in the background without a user interface.
 With Android 5.0 (API level 21) and later, you can start a service with JobScheduler.

For versions earlier than Android 5.0 (API level 21), you can start a service by using methods
 of the Service class. You can start a service to perform a one-time operation (such as
 downloading a file) by passing an Intent to startService(). The Intent describes the service
  to start and carries any necessary data.

If the service is designed with a client-server interface, you can bind to the service from
another component by passing an Intent to bindService().

3.Delivering a broadcast
A broadcast is a message that any app can receive. The system delivers various broadcasts
for system events, such as when the system boots up or the device starts charging. You can
 deliver a broadcast to other apps by passing an Intent to sendBroadcast() or
 sendOrderedBroadcast().



 Intent types
There are two types of intents:

1.Explicit intents ==> specify which application will satisfy the intent, by supplying either
the target app's package name or a fully-qualified component class name. You'll typically use
an explicit intent to start a component in your own app, because you know the class name of
the activity or service you want to start. For example, you might start a new activity within
your app in response to a user action, or start a service to download a file in the background.

Implicit intents ==>do not name a specific component, but instead declare a general action to
perform, which allows a component from another app to handle it. For example, if you want to
show the user a location on a map, you can use an implicit intent to request that another
capable app show a specified location on a map.


Intent-Filter:==>An intent filter is an expression in an app's manifest file that specifies
the type of intents that the component would like to receive. For instance, by declaring an
intent filter for an activity, you make it possible for other apps to directly start your
activity with a certain kind of intent. Likewise, if you do not declare any intent filters
for an activity, then it can be started only with an explicit intent.


 */