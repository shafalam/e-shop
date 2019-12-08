import {Product} from "./product";

export class Customer {
  id: number;
  name: string;
  email: string;
  paymentMethod: string;
  balance: number;
  password: string;
  buyingHistory: Product[];
}
