import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { JWTService } from '../services/jwt.service';
import { Site } from '../models/site'
import { ApiService } from '../services/api.service';
import { Teatro } from '../models/teatro';
import { Promocao } from '../models/promocao';

@Injectable({ providedIn: 'root' })
export class OwnerGuard implements CanActivate {
    site: Site = null;
    teatro: Teatro = null;
    promocao: Promocao = null;
    constructor(
        private router: Router,
        private api: ApiService,
        private jwt: JWTService
    ) {}

    async canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        
        const url = route.url[0].toString();
        const id = parseInt(route.url[1].path);
        
        if (url.includes("site")) {
            this.site = await this.api.getSite(id).toPromise();
            if(this.jwt.isOwner(this.site.username) || this.jwt.isAdmin) return true;
        } else if (url.includes("teatro")){
            this.teatro = await this.api.getTeatro(id).toPromise();
            if(this.jwt.isOwner(this.teatro.username) || this.jwt.isAdmin) return true;
        } else if (url.includes("promocao")){
            this.promocao = await this.api.getPromocao(id).toPromise();
            if(this.jwt.isOwner(this.promocao.teatro.username) || this.jwt.isAdmin) return true;
        }
        
        // not logged in so redirect to login page with the return url
        this.router.navigate(['/login'], { queryParams: { returnUrl: state.url }});
        return false;
    }
}
