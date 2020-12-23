<#import "parts/common.ftl" as c>

<@c.page>
<h1>Registration</h1>
<form action="/registration" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> User Name : </label>
        <div class="col-sm-6">
            <input type="text"
                   class="form-control ${(nameInvalid??)?string('is-invalid','')}"
                   name="name"/>
            <#if nameInvalid??>
            <div class="invalid-feedback">
                ${nameInvalid}
            </div>
            </#if>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Email : </label>
        <div class="col-sm-6">
            <input type="text"
                   class="form-control ${(emailInvalid??)?string('is-invalid','')}"
                   name="email"/>
            <#if emailInvalid??>
            <div class="invalid-feedback">
                ${emailInvalid}
            </div>
            </#if>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Password: </label>
        <div class="col-sm-6">
            <input type="password"
                   class="form-control ${(passwordInvalid??)?string('is-invalid','')}"
                   name="password"/>
            <#if passwordInvalid??>
            <div class="invalid-feedback">
                ${passwordInvalid}
            </div>
            </#if>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary">Create account</button>
</form>
</@c.page>