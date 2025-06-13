#
# Copyright (C) 2022 FlamingoOS Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# HIDL
DEVICE_FRAMEWORK_COMPATIBILITY_MATRIX_FILE += $(CONFIG_PATH)/hidl/dolby_framework_matrix.xml
DEVICE_MANIFEST_FILE += $(CONFIG_PATH)/hidl/vendor.dolby.hardware.dms@2.0-service.xml
DEVICE_MANIFEST_FILE += $(CONFIG_PATH)/hidl/vendor.dolby.media.c2.xml

# Enable codec support
AUDIO_FEATURE_ENABLED_DS2_DOLBY_DAP := true