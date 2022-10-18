import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class PackagesService {
  data:any
  public setMessage(message:any){
    this.data=message;
  }
 public getMessage(): any {
    return this.data;    
  }

  constructor(private http:HttpClient) { }
  
  public getAllPackages(){
   return this.http.get(`${baseUrl}/packages/all`);
  }
  public createPackage(packages:any){
    return this.http.post(`${baseUrl}/packages/`,packages);
   }

   public deletePackage(id:any){
    return this.http.delete(`${baseUrl}/packages/delete/${id}`);
   }

}
