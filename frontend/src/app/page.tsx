'use client';

import React, { useState } from "react";
import { faker } from "@faker-js/faker";
import { createClient, getAllClients, Client } from "../lib/client";
import { createRepas, getAllRepas, Repas } from "../lib/repas";
import { createItem, getAllItems, Inventory } from "../lib/inventory";

const Page = () => {
  //console.log("api url : "+ process.env.NEXT_PUBLIC_APIURL);
  const [clientResult, setClientResult] = useState<string>("");
  const [repasResult, setRepasResult] = useState<string>("");
  const [inventoryResult, setInventoryResult] = useState<string>("");

  // Handlers for Client API
  const handleTestClientGetAll = async () => {
    try {
      const clients = await getAllClients();
      setClientResult(JSON.stringify(clients, null, 2));
    } catch (error: any) {
      setClientResult(error.message);
    }
  };

  const handleTestClientPost = async () => {
    try {
      const newClient: Client = {
        name: faker.person.fullName(),
        email: faker.internet.email(),
        phone: faker.phone.number(),
        address: faker.location.streetAddress(),
      };
      const client = await createClient(newClient);
      setClientResult(JSON.stringify(client, null, 2));
    } catch (error: any) {
      setClientResult(error.message);
    }
  };

  // Handlers for Repas API
  const handleTestRepasGetAll = async () => {
    try {
      const repas = await getAllRepas();
      setRepasResult(JSON.stringify(repas, null, 2));
    } catch (error: any) {
      setRepasResult(error.message);
    }
  };

  const handleTestRepasPost = async () => {
    try {
      const newRepas: Repas = {
        name: "pizza fromage",
        ingredients: {
        "tomate": 1, "onion":2
        },
      };
      const repas = await createRepas(newRepas);
      setRepasResult(JSON.stringify(repas, null, 2));
    } catch (error: any) {
      setRepasResult(error.message);
    }
  };

  // Handlers for Inventory API
  const handleTestInventoryGetAll = async () => {
    try {
      const items = await getAllItems();
      setInventoryResult(JSON.stringify(items, null, 2));
    } catch (error: any) {
      setInventoryResult(error.message);
    }
  };

  const handleTestInventoryPost = async () => {
    try {
      const newItem: Inventory = {
        name: faker.food.ingredient(),
        quantity: faker.number.int({ min: 1, max: 100 }),
      };
      const item = await createItem(newItem);
      setInventoryResult(JSON.stringify(item, null, 2));
    } catch (error: any) {
      setInventoryResult(error.message);
    }
  };

  return (
    <div className="flex justify-evenly items-center h-screen">
      {/* Div 1: Client Testing */}
      <div className="w-[31vw] h-[95vh] rounded-lg bg-red-500 text-white font-bold flex flex-col justify-center items-center p-4">
        <h2>Client API </h2>
        <button
          className="bg-white text-red-500 p-2 rounded mt-4"
          onClick={handleTestClientGetAll}
        >
          Get All Clients
        </button>
        <button
          className="bg-white text-red-500 p-2 rounded mt-4"
          onClick={handleTestClientPost}
        >
          Create Random Client
        </button>
        <pre className="bg-white text-black p-2 rounded mt-4 w-full overflow-auto">
          {clientResult}
        </pre>
      </div>

      {/* Div 2: Repas Testing */}
      <div className="w-[31vw] h-[95vh] rounded-lg bg-green-500 text-white font-bold flex flex-col justify-center items-center p-4">
        <h2>Repas API</h2>
        <button
          className="bg-white text-green-500 p-2 rounded mt-4"
          onClick={handleTestRepasGetAll}
        >
          Get All Repas
        </button>
        <button
          className="bg-white text-green-500 p-2 rounded mt-4"
          onClick={handleTestRepasPost}
        >
          Create Random Repas
        </button>
        <pre className="bg-white text-black p-2 rounded mt-4 w-full overflow-auto">
          {repasResult}
        </pre>
      </div>

      {/* Div 3: Inventory Testing */}
      <div className="w-[31vw] h-[95vh] rounded-lg bg-blue-500 text-white font-bold flex flex-col justify-center items-center p-4">
        <h2>Inventory API</h2>
        <button
          className="bg-white text-blue-500 p-2 rounded mt-4"
          onClick={handleTestInventoryGetAll}
        >
          Get All Inventory Items
        </button>
        <button
          className="bg-white text-blue-500 p-2 rounded mt-4"
          onClick={handleTestInventoryPost}
        >
          Create Random Inventory Item
        </button>
        <pre className="bg-white text-black p-2 rounded mt-4 w-full overflow-auto">
          {inventoryResult}
        </pre>
      </div>
    </div>
  );
};

export default Page;
