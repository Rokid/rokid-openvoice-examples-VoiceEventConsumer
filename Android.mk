LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE_TAGS:=optional
LOCAL_PROGUARD_ENABLED := disabled
LOCAL_PACKAGE_NAME := RKVoiceEventConsumer
BEARKID_SRC_FILES := \
	aidl/com/rokid/voicerec/BearKid.aidl \
	aidl/com/rokid/voicerec/CustomWord.java \
	aidl/com/rokid/voicerec/BearKidResult.java
LOCAL_SRC_FILES := \
	$(BEARKID_SRC_FILES) \
	java/com/rokid/example/vsysdev/RKVoiceEventConsumerActivity.java \
	java/com/rokid/example/vsysdev/RKVoiceEventConsumerService.java \
	java/com/rokid/example/vsysdev/VoiceEventHandler.java
LOCAL_AIDL_INCLUDES := $(LOCAL_PATH)/aidl
include $(BUILD_PACKAGE)
