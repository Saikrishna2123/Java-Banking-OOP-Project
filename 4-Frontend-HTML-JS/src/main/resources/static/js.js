const API_URL = "/api/products";


// Load products
function loadProducts() {

    fetch(API_URL)
        .then(response => response.json())
        .then(products => {

            const tableBody =
                document.getElementById("productTableBody");

            tableBody.innerHTML = "";

            products.forEach(product => {

                const row = document.createElement("tr");

                row.innerHTML = `
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>₹${product.price}</td>
                `;

                tableBody.appendChild(row);
            });
        })
        .catch(error => {

            console.error("Error:", error);

            alert("Unable to load products");
        });
}


// Add product
function addProduct() {

    const name =
        document.getElementById("productName").value;

    const price =
        document.getElementById("productPrice").value;

    if (name === "" || price === "") {

        alert("Please enter product name and price");

        return;
    }

    const product = {

        name: name,

        price: Number(price)
    };


    fetch(API_URL, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(product)
    })

        .then(response => {

            if (!response.ok) {

                throw new Error("Failed to add product");
            }

            return response.json();
        })

        .then(data => {

            alert("Product added successfully!");

            document.getElementById("productName").value = "";

            document.getElementById("productPrice").value = "";

            loadProducts();
        })

        .catch(error => {

            console.error("Error:", error);

            alert("Unable to add product");
        });
}


// Load products when page opens
loadProducts();