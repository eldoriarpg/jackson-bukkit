#!/usr/bin/env bash

if [ $# -ne 3 ]; then
  echo "$0 <module> <main|test> <name>"
  exit 0
fi


touch $PWD/$1/src/$2/resources/json/$3.json
touch $PWD/$1/src/$2/resources/json/$3_list.json
touch $PWD/$1/src/$2/resources/yaml/$3.yaml
touch $PWD/$1/src/$2/resources/yaml/$3_list.yaml
touch $PWD/$1/src/$2/resources/toml/$3.toml
touch $PWD/$1/src/$2/resources/toml/$3_list.toml

exit 0
