<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="connexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="login" name="login" value="Clement.aziblaireau"/>
                <span class="erreur"></span>
                <br />

                <label for="motdepasse">Mot de passe</label>
                <input type="password" id="motdepasse" name="motdepasse" value="" />
                <span class="erreur"><% if(request.getAttribute("messageErreur") != null) {out.println( request.getAttribute("messageErreur") ); }%></span>
                <br />

                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
                
                <p></p>
            </fieldset>
        </form>
    </body>
</html>