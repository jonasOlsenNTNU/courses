const API_BASE_URL = "http://localhost:8080/api";

async function requestData(apiUrl, responseHandler) {
    const url = API_BASE_URL + apiUrl;
    const response = await fetch(url);
    if (reponse.ok) {
        const responseData = await response.json();
        if (responseData) {
            responseHandler(responseData);
        }
    }
}