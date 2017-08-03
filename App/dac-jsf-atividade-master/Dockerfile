FROM payara/micro
COPY target/AtividadeJSF.war AtividadeJSF.war
CMD ["java", "-jar", "payara-micro.jar", "--deploy", "AtividadeJSF.war"]

#Caso voce deseje utilizar o payara full
#FROM payara/server-full
#ENV DOMAIN domain1
#ENV LIB /opt/payara41/glassfish/domains/${DOMAIN}/lib/
#ENV DEPLOY ${PAYARA_PATH}/glassfish/domains/${DOMAIN}/autodeploy/
#ADD target/AtividadeJSF/WEB-INF/lib/ ${LIB}
#ENTRYPOINT $PAYARA_PATH/bin/asadmin start-domain --verbose ${DOMAIN}
#ADD target/AtividadeJSF.war  ${DEPLOY}
