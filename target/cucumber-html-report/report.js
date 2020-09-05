$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/RegresAPIs.feature");
formatter.feature({
  "name": "Resgres APIs this is for practice RestAssured",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Login Resgres",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I have the email \u003cemail\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I have the password \u003cpassword\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I have the keyHeader \u003ckeyHeader\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I have the headerValue \u003cheaderValue\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I set the endpoint \u003cendpoint\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "I can verify the status code \u003cstatus\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password",
        "keyHeader",
        "headerValue",
        "endpoint",
        "status"
      ]
    },
    {
      "cells": [
        "eve.holt@reqres.in",
        "cityslicka",
        "Content-Type",
        "application/json",
        "Login",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login Resgres",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have the email eve.holt@reqres.in",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.i_have_the_email(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have the password cityslicka",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.i_have_the_password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have the keyHeader Content-Type",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.i_have_the_keyHeader(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have the headerValue application/json",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.i_have_the_headerValue(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I set the endpoint Login",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.i_set_the_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can verify the status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.i_can_verify_the_status_code(int)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Create resource Resgres",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I have the name \u003cname\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I have the job \u003cjob\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I have the keyHeader \u003ckeyHeader\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I have the headerValue \u003cheaderValue\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I set the endpoint \u003cendpoint\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "I can verify the status \u003cstatus\u003e to create resource",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "job",
        "keyHeader",
        "headerValue",
        "endpoint",
        "status"
      ]
    },
    {
      "cells": [
        "eve.holt@reqres.in",
        "cityslicka",
        "Content-Type",
        "application/json",
        "Users",
        "201"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Create resource Resgres",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have the name eve.holt@reqres.in",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.i_have_the_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have the job cityslicka",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.i_have_the_job(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have the keyHeader Content-Type",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.i_have_the_keyHeader(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have the headerValue application/json",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.i_have_the_headerValue(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I set the endpoint Users",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.i_set_the_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can verify the status 201 to create resource",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.i_can_verify_the_status_to_create_resource(int)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Search a single User Resgres",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I have the name \u003cname\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I have the lastname \u003clastname\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I have the id \u003cid\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I set the endpoint \u003cendpoint\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "I can verify for a single user the status code \u003cstatus\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "lastname",
        "id",
        "endpoint",
        "status"
      ]
    },
    {
      "cells": [
        "Michael",
        "Lawson",
        "7",
        "Users",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Search a single User Resgres",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have the name Michael",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.i_have_the_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have the lastname Lawson",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.i_have_the_lastname(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have the id 7",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.i_have_the_id(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I set the endpoint Users",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.i_set_the_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can verify for a single user the status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.i_can_verify_for_a_single_user_the_status_code(int)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});