#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_jqk_jni_NDKTools_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
jstring get_hello(JNIEnv *env, jobject clazz) {
    return env->NewStringUTF("hello jni");
}

static JNINativeMethod g_methods[] = {
        {"getHello", "()Ljava/lang/String;", (void *) get_hello}
};

extern "C"
JNIEXPORT int JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env;
    if (vm->GetEnv((void **) &env, JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }
    const char *class_path = "com/jqk/jni/NDKTools";//这里对应native的java类
    jclass javaClass = env->FindClass(class_path);
    if (javaClass == nullptr) {
        return JNI_ERR;
    }

    int method_count = sizeof(g_methods) / sizeof(g_methods[0]);
    if (env->RegisterNatives(javaClass, g_methods, method_count) < 0) {
        return JNI_ERR;
    }

    return JNI_VERSION_1_6;
}
