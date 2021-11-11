function getPerson()
{
    fetch('./person')
        .then(response => response.json())
        .then(data => {
            let html = "";

            data.forEach(d => html+=`<tr><td>${d.id}</td><td>${d.firstname} ${d.lastname}</td></tr>`);

            document.getElementById("result").innerHTML = html;
        });
}

function addPerson(id, firstname, lastname)
{
    let data = {
        "id":id,
        "firstname":firstname,
        "lastname":lastname
    }

    fetch('./person',
        {
            method:"post",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(data)
        }
        ).then(response => alert(response.status + " " + response.statusText));
}