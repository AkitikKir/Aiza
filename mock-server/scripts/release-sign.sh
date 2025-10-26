#!/usr/bin/env bash
KEYSTORE_PATH="$1"
KEY_ALIAS="$2"
KEY_PASS="$3"
if [ -z "$KEYSTORE_PATH" ]; then
  echo "Usage: release-sign.sh <keystore> <alias> <password>"
  exit 1
fi
# Gradle signing config should reference these properties via gradle.properties or env
echo "Sign config should be placed in gradle.properties or passed via CI secrets"

