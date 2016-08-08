#include<jni.h>
#include<string.h>

jstring Java_me_finalproject_com_apchemchemolyapp_balanceEq_helloWorld(JNIEnv* env, jobject obj);
{
    return (*env)->NewStringUTF(env,"Hello World");
}