# ViPER4Android FX
- Add this in **device.mk**: $(call inherit-product, hardware/motorola/ViPER4AndroidFX/setup.mk)

Add this to your **audio_effects.xml**:

    <library name="v4a_re" path="libv4a_re.so"/>
    <effect name="v4a_standard_re" library="v4a_re" uuid="90380da3-8536-4744-a6a3-5731970e640f"/>
