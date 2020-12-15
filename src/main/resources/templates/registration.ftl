<#import "parts/common.ftl" as c>

<@c.page>
<h1>Registration</h1>
<form action="/registration" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> User Name : </label>
        <div class="col-sm-6">
            <input type="text" class="form-control" name="username"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Email : </label>
        <div class="col-sm-6">
            <input type="text" class="form-control" name="email"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Password: </label>
        <div class="col-sm-6">
            <input type="password" class="form-control" name="password"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary">Create account</button>
</form>
</@c.page>