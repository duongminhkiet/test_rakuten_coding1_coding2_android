#include <jni.h>


jint c = 0;

extern "C" JNIEXPORT jint JNICALL
Java_com_example_duongminhkiet_myapplication_CodingTest1_numberFromJNIC(JNIEnv* env, jobject obj) {
    return c++;
}

