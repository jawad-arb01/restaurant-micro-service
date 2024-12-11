const API_BASE_URL = "https://inventory"+process.env.NEXT_PUBLIC_APIURL  +"/inventory";

// Define TypeScript interfaces for Inventory and ingredients map
export interface Inventory {
  id?: string; // Optional for creation
  name: string;
  quantity: number;
}

// API functions

// Get all inventory items
export async function getAllItems(): Promise<Inventory[]> {
  const response = await fetch(`${API_BASE_URL}`);
  if (!response.ok) throw new Error("Failed to fetch inventory items");
  return response.json();
}

// Get an inventory item by ID
export async function getItemById(id: string): Promise<Inventory> {
  const response = await fetch(`${API_BASE_URL}/${id}`);
  if (!response.ok) throw new Error(`Failed to fetch inventory item with ID ${id}`);
  return response.json();
}

// Create a new inventory item
export async function createItem(item: Inventory): Promise<Inventory> {
  const response = await fetch(`${API_BASE_URL}`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(item),
  });
  if (!response.ok) throw new Error("Failed to create inventory item");
  return response.json();
}

// Update an existing inventory item
export async function updateItem(id: string, item: Inventory): Promise<Inventory> {
  const response = await fetch(`${API_BASE_URL}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(item),
  });
  if (!response.ok) throw new Error(`Failed to update inventory item with ID ${id}`);
  return response.json();
}

// Delete an inventory item
export async function deleteItem(id: string): Promise<void> {
  const response = await fetch(`${API_BASE_URL}/${id}`, {
    method: "DELETE",
  });
  if (!response.ok) throw new Error(`Failed to delete inventory item with ID ${id}`);
}

// Decrease ingredient quantities
export async function decreaseIngredientQuantities(ingredients: Record<string, number>): Promise<void> {
  const response = await fetch(`${API_BASE_URL}/decrease-ingredients`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(ingredients),
  });
  if (!response.ok) throw new Error("Failed to decrease ingredient quantities");
}
