LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE_TAGS:=optional
LOCAL_PROGUARD_ENABLED := disabled
LOCAL_PACKAGE_NAME := RKVoiceEventConsumer
LOCAL_SRC_FILES := \
	java/com/rokid/example/vsysdev/RKVoiceEventConsumerActivity.java \
	java/com/rokid/example/vsysdev/RKVoiceEventConsumerService.java \
	java/com/rokid/example/vsysdev/VoiceEventHandler.java
include $(BUILD_PACKAGE)
