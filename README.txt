Country:
            Country list: GET
        http://localhost:8080/tourism-sport/country/list

            Add country: POST
        http://localhost:8080/tourism-sport/country/add
            {
                "name":
            }

            Update country: POST
        http://localhost:8080/tourism-sport/country/update
            {
              "id": ,
              "name":
            }

            Delete country: DELETE
        http://localhost:8080/tourism-sport/country/delete/id


Region:
            Region list: GET
        http://localhost:8080/tourism-sport/region/list

            Add region: POST
        http://localhost:8080/tourism-sport/region/add
            {
                "idCountry":,
                "name":
            }

            Update region: POST
        http://localhost:8080/tourism-sport/region/update
            {
              "id":
              "idCountry":
              "name":
            }

            Delete country: DELETE
        http://localhost:8080/tourism-sport/region/delete/id


Locality:
            Locality list: GET
        http://localhost:8080/tourism-sport/locality/list

            Add locality: POST
        http://localhost:8080/tourism-sport/locality/add
            {
                "idRegion":,
                "name":
            }

            Update region: POST
        http://localhost:8080/tourism-sport/locality/update
            {
              "id":
              "idRegion":
              "name":
            }

            Delete locality: DELETE
        http://localhost:8080/tourism-sport/locality/delete/id


LocalitySport:
            LocalitySport list: GET
        http://localhost:8080/tourism-sport/localitySport/list

            Add localitySport: POST
        http://localhost:8080/tourism-sport/localitySport/add
            {
                "idSport":,
                "idLocality":,
                "startSeason":dd/MM/yyyy,
                "endSeason":dd/MM/yyyy,
                "costDay":;
            }

            Update localitySport: POST
        http://localhost:8080/tourism-sport/localitySport/add
            {
                "id":,
                "idSport":,
                "idLocality":,
                "startSeason":"dd/MM/yyyy",
                "endSeason":"dd/MM/yyyy",
                "costDay":;
            }

            Delete locality: DELETE
        http://localhost:8080/tourism-sport/localitySport/delete/id


Sport:
            Sports list: GET
        http://localhost:8080/tourism-sport/sport/list

            Add sport: POST
        http://localhost:8080/tourism-sport/sport/add
            {
                "name":
            }
            Update sport: POST
        http://localhost:8080/tourism-sport/localitySport/add
            {
                "id":,
                "name":
            }

            Delete sport: DELETE
        http://localhost:8080/tourism-sport/sport/delete/id

Filter:

    http://localhost:8080/tourism-sport/filter/sportDate
        {
            "idSports":[],
            "startSeason":"dd/MM/yyyy",
            "endSeason":"dd/MM/yyyy",
        }









