import {Injectable}     from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Item}           from './item';      
import {Observable}     from 'rxjs/Observable'
import 'rxjs/Rx'; 

@Injectable()
export class ItemService{
    
    _itemsUrl = 'http://localhost:8080/grocery-buddy-service/services/getAllItems';
   
    constructor(private http:Http){

    }

    public getItems(): Observable<Item[]>{
        //console.info('URL: ' + this._itemsUrl);
        
        return this.http.get(this._itemsUrl)
                .map(res => <Item[]> res.json())
                .catch(this.handleError);
    }

    public getItemsAsStr(){
        //console.info('URL: ' + this._itemsUrl);
        return this.http.get(this._itemsUrl);
    }

    public getURL(): string{
        return this._itemsUrl;
    }

    handleError(error: Response){
        console.error(error);
        return Observable.throw(error.json().error || 'Server Error');
    }
    
}