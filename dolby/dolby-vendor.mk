PRODUCT_SOONG_NAMESPACES += \
    hardware/motorola/dolby

PRODUCT_COPY_FILES += \
    hardware/motorola/dolby/proprietary/vendor/etc/dolby/dax-default.xml:$(TARGET_COPY_OUT_VENDOR)/etc/dolby/dax-default.xml \
    hardware/motorola/dolby/proprietary/vendor/etc/init/vendor.dolby.hardware.dms@2.0-service.rc:$(TARGET_COPY_OUT_VENDOR)/etc/init/vendor.dolby.hardware.dms@2.0-service.rc \
    hardware/motorola/dolby/proprietary/vendor/etc/media_codecs_dolby_audio.xml:$(TARGET_COPY_OUT_VENDOR)/etc/media_codecs_dolby_audio.xml

PRODUCT_PACKAGES += \
    DolbyManager \
    libdapparamstorage \
    libdeccfg \
    libdlbdsservice \
    libstagefright_soft_ac4dec \
    libstagefright_soft_ddpdec \
    libswdap \
    libswgamedap \
    libswvqe \
    libqcbassboost \
    libqcreverb \
    libqcvirt \
    vendor.dolby.hardware.dms@2.0 \
    vendor.dolby.hardware.dms@2.0-impl \
    vendor.dolby.hardware.dms@2.0-service
