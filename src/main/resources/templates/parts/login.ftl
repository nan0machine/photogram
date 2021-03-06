<#macro login path>
<form action="${path}" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> User Name : </label>
        <div class="col-sm-6">
            <input type="text" class="form-control"  name="username" placeholder="Your nickname"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Password:  </label>
        <div class="col-sm-6">
            <input type="password" class="form-control" name="password" placeholder="Your password"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary">Sign Out</button>
</form>
</#macro>