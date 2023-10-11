service_label='troetbot'

# Defines a flag for local development. When the local flag is passed, then the deployed image is build with gradle
# instead of taking the prebuilt image.
config.define_bool('local',args=False,usage='When set, the image is built locally reflecting your changes.')
cfg = config.parse()
is_local = cfg.get('local')

if is_local:
    custom_build(service_label,
                     './gradlew build -x test '+
                     '-Dquarkus.container-image.build=true -Dquarkus.container-image.image=$EXPECTED_IMAGE:$EXPECTED_TAG -Dquarkus.container-image.labels."dev.tilt.gc"=true -Dquarkus.profile=dev',
         command_bat='.\\gradlew build -x test '+
                     '-Dquarkus.container-image.build=true -Dquarkus.container-image.image=%$EXPECTED_IMAGE%:%$EXPECTED_TAG% -Dquarkus.container-image.labels."dev.tilt.gc"=true -Dquarkus.profile=dev',
         deps=['./gradle','build.gradle',
               'settings.gradle',
               './src/main/java',
               '/src/main/kubernetes/',
               '.src/main/resources/application.properties',
               ])
    k8s_yaml(kustomize('./src/main/kubernetes/environment/local'))
else:
    k8s_yaml(kustomize('./src/main/kubernetes/environment/prod'))

k8s_resource(workload=service_label, port_forwards='8888:8080',labels=[service_label])
