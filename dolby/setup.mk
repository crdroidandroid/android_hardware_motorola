# Inherit dolby configuration
$(call inherit-product, hardware/motorola/dolby/dolby-vendor.mk)

CONFIG_PATH := hardware/motorola/dolby

# AudioFX
TARGET_EXCLUDES_AUDIOFX := true

# SEPolicy
BOARD_VENDOR_SEPOLICY_DIRS += $(CONFIG_PATH)/sepolicy/vendor
