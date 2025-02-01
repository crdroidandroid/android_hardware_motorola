# Inherit dolby configuration
$(call inherit-product, hardware/motorola/dolby/dolby-vendor.mk)

CONFIG_PATH := hardware/motorola/dolby

# AudioFX
TARGET_EXCLUDES_AUDIOFX := true

# HIDL
DEVICE_MANIFEST_FILE += $(CONFIG_PATH)/hidl/manifest.xml
DEVICE_FRAMEWORK_COMPATIBILITY_MATRIX_FILE += $(CONFIG_PATH)/hidl/framework_compatibility_matrix.xml

# Props Override
PRODUCT_PROPERTY_OVERRIDES += \
	persist.vendor.audio_fx.current=dolby \
	vendor.audio.dolby.ds2.enabled=true \
	vendor.audio.dolby.ds2.hardbypass=true

# SEPolicy
BOARD_VENDOR_SEPOLICY_DIRS += $(CONFIG_PATH)/sepolicy/vendor
