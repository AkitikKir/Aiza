#!/usr/bin/env bash
set -e
cd "$(dirname "$0")/../mock-server"
if [ ! -d "node_modules" ]; then
  echo "installing dependencies..."
  npm install
fi
node index.js

