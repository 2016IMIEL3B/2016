<a class="btn btn-default" href="/">Annuler</a>
<button type="submit" class="btn btn-primary pull-right">Valider</button>
<c:set var="stepStat" scope="session" value="${(step-1)*25}"/>
Etape <c:out value="${step}" />/4
<div class="progress">
    <div class="progress-bar progress-bar-striped progress-bar-success active" style="width:${stepStat}%">
    </div>
    <div class="progress-bar progress-bar-striped progress-bar-primary active" style="width: 25%">
    </div>
</div>
