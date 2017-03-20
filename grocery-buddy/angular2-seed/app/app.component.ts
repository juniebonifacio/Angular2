import {Component}   from 'angular2/core';
import {ItemService} from './item.service';
import {Item} from './item';

@Component({
    selector: 'my-app',
    template: `
    <h1>Item Web Service Client App</h1>
    <table title='Grocery Items Buddy'>
        <tr>
            <th>Item ID</th>
            <th>Description</th>
            <th>Owner ID</th>
        </tr>
        <tr *ngFor="#item of items">
            <td>{{item.id}}</td>
            <td>{{item.name}}</td>
            <td>{{item.ownerId}}</td>
        </tr>
    </table>
  
    `,
    providers: [ItemService]
})

export class AppComponent { 
    items: Item[];
    errorString: string;
    
    isFinished: boolean = false;

    constructor(private _itemService: ItemService){
        
    }

    ngOnInit(){
        this.getItems();
    }

    public getItems(){
        this._itemService.getItems()
            .subscribe(
                wsItems => this.items = wsItems,
                error => this.errorString = <any> error
            );
        

    }
}