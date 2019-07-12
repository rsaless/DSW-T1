import { Site } from './site';
import { Teatro } from './teatro';

export class Promocao {
    id: string;
    nome_peca: string;
    preco: number;
    dia_hora: Date;
    site: Site;
    teatro: Teatro;
}
