import { Site } from './site';
import { Teatro } from './teatro';

export class Promocao {
    id: string;
    nome_peca: string;
    preco: number;
    cnpj: string;
    dia_hora: Date;
    nome_site: string;
    site: Site;
    teatro: Teatro;
}
