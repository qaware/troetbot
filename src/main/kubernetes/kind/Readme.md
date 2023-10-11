# Kind cluster config

This directory contains a kind cluster config for bootstrapping a local cluster that is fit for the deployment via the [Tiltfile](../../../../Tiltfile).

## Create the Cluster
```shell
$ kind create cluster --name cc-2023 --config kind-cluster-config.yaml 
```

## Delete Cluster
```shell
$ kind delete cluster --name cc-2023 
```